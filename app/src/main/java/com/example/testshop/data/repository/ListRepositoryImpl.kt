package com.example.testshop.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testshop.data.database.AppDataBase
import com.example.testshop.data.mapper.Mapper
import com.example.testshop.data.network.ApiFactory
import com.example.testshop.domain.ListRepository
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class ListRepositoryImpl(application: Application) : ListRepository {

    private val userInfoDao = AppDataBase.getInstance(application).UsersDao()
    private val apiService = ApiFactory.apiService
    private val mapper = Mapper()

    private val flashSaleLD: MutableLiveData<List<FlashSale>> = MutableLiveData()
    override fun getFlashSaleList(): LiveData<List<FlashSale>> {
        return flashSaleLD
    }

    private val latestLD: MutableLiveData<List<Latest>> = MutableLiveData()
    override fun getLatestList(): LiveData<List<Latest>>{
        return latestLD
    }

    override suspend fun loadData() {
        try {
            val latest = apiService.getLatestInfo()
            val flashSale = apiService.getFlashSaleInfo()
            if (latest.isSuccessful && flashSale.isSuccessful) {
                val itemsLatest = latest.body()?.latestDto
                val itemsFlashSale = flashSale.body()?.flashSaleDto
                withContext(Dispatchers.Main){
                    latestLD.value = itemsLatest?.map{mapper.mapDtoModelToLatest(it)}
                    flashSaleLD.value = itemsFlashSale?.map{ mapper.mapDtoModelToFlashSale(it)}
                }
            }
        } catch (e:Exception){
            Log.d("LoadData","ListRepositoryImpl.class : $e")
        }
        delay(1000)
    }
}






