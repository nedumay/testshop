package com.example.testshop.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testshop.data.database.UsersDao
import com.example.testshop.data.mapper.Mapper
import com.example.testshop.data.network.ApiService
import com.example.testshop.domain.Repository
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest
import com.example.testshop.domain.model.users.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val usersInfoDao: UsersDao,
    private val apiService: ApiService,
) : Repository {

    private val flashSaleLD: MutableLiveData<List<FlashSale>> = MutableLiveData()
    override fun getFlashSaleList(): LiveData<List<FlashSale>> {
        return flashSaleLD
    }

    private val latestLD: MutableLiveData<List<Latest>> = MutableLiveData()
    override fun getLatestList(): LiveData<List<Latest>> {
        return latestLD
    }

    override suspend fun loadData() {
        try {
            val latest = apiService.getLatestInfo()
            val flashSale = apiService.getFlashSaleInfo()
            if (latest.isSuccessful && flashSale.isSuccessful) {
                val itemsLatest = latest.body()?.latestDto
                val itemsFlashSale = flashSale.body()?.flashSaleDto
                withContext(Dispatchers.Main) {
                    latestLD.value = itemsLatest?.map { mapper.mapDtoModelToLatest(it) }
                    flashSaleLD.value = itemsFlashSale?.map { mapper.mapDtoModelToFlashSale(it) }
                }
            }
        } catch (e: Exception) {
            Log.d("LoadData", "ListRepositoryImpl.class : $e")
        }
    }

    override suspend fun addUserToDb(user: User) {
        usersInfoDao.insertUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun deleteUserFromDb(firstName: String) {
        usersInfoDao.deleteUser(firstName)
    }

    override suspend fun getUserFromDb(firstName: String): User {
        val dbModel = usersInfoDao.getFirstNameUser(firstName)
        return  mapper.mapDbModelToEntity(dbModel)
    }
}






