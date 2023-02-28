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
            if (latest.isSuccessful) {
                val itemsLatest = latest.body()?.latestDto
                withContext(Dispatchers.Main){
                    latestLD.value = itemsLatest?.map{mapper.mapDtoModelToLatest(it)}
                }
            }
        } catch (e:Exception){
            Log.d("LoadData","ListRepositoryImpl.class : $e")
        }
        delay(10000)

        /*
        val flashSale = apiService.getFlashSaleInfo()
        Log.d("LoadData", "Flash: $flashSale")
        if (latest.isSuccessful && flashSale.isSuccessful) {
            val itemsLatest = latest.body()?.latestDto
            //latestLD.value = itemsLatest
            Log.d("LoadData", "$itemsLatest")
            val itemsFlashSale = flashSale.body()?.flashSaleDto
            //flashSaleLD.value = itemsFlashSale
            Log.d("LoadData", "$itemsFlashSale")
            if (itemsLatest != null && itemsFlashSale != null) {
                for (i in 0 until itemsLatest.count()) {
                    val category = itemsLatest[i].category
                    val name = itemsLatest[i].name
                    val price = itemsLatest[i].price
                    val image = itemsLatest[i].image_url
                    Log.d("LoadData", "")
                }
                for (i in 0 until itemsFlashSale.count()) {
                    val category = itemsFlashSale[i].category
                    val name = itemsFlashSale[i].name
                    val price = itemsFlashSale[i].price
                    val discount = itemsFlashSale[i].discount
                    val image = itemsFlashSale[i].image_url
                    Log.d("LoadData", "$category,$name,$price,$discount,$image")
                }
            }
        }*/
    }
}






