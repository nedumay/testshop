package com.example.testshop.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testshop.data.network.ApiFactory
import com.example.testshop.domain.ListRepository
import com.example.testshop.domain.model.flashSale.FlashSale
import com.example.testshop.domain.model.latest.Latest

class ListRepositoryImpl : ListRepository {

    private val latestLD: MutableLiveData<List<Latest>> = MutableLiveData()
    private val flashSaleLD: MutableLiveData<List<FlashSale>> = MutableLiveData()


    private val apiService = ApiFactory.apiService

    override fun getFlashSaleList(): LiveData<List<FlashSale>> {
        return flashSaleLD
    }

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
                if (itemsLatest != null && itemsFlashSale != null) {
                    for (i in 0 until itemsLatest.count()) {
                        val category = itemsLatest[i].category
                        val name = itemsLatest[i].name
                        val price = itemsLatest[i].price
                        val image = itemsLatest[i].image_url
                        Log.d("LoadDataLatest", "")
                    }
                    for (i in 0 until itemsFlashSale.count()){
                        val category = itemsFlashSale[i].category
                        val name = itemsFlashSale[i].name
                        val price = itemsFlashSale[i].price
                        val discount = itemsFlashSale[i].discount
                        val image = itemsFlashSale[i].image_url
                        Log.d("LoadDataLatest", "$category,$name,$price,$discount,$image")
                    }
                }
            }
        } catch (e: java.lang.Exception) {

        }

    }
}





