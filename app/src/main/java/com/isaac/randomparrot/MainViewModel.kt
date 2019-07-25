package com.isaac.randomparrot

import android.util.Log
import androidx.lifecycle.*
import com.isaac.randomparrot.model.Parrot
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _randomParrot = MutableLiveData<Parrot>()
    val randomParrot: LiveData<Parrot> = _randomParrot

    private var parrotList : List<Parrot>? = null
    private val repository: ParrotRepository = ParrotRepository()

    //var getParrotList = liveData(Dispatchers.IO) {
    //    if (parrotList == null) {
    //        parrotList = repository.getParrots()
    //    }
//
    //    val randomParrot = parrotList!![Random.nextInt(0, parrotList!!.size - 1)]
    //    Log.i("MainViewModel", randomParrot.toString())
//
    //    emit(parrotList!!)
    //}

    fun refreshRandomParrot() {
        viewModelScope.launch {
            // suspend and resume make this database request main-safe
            // so our ViewModel doesn't need to worry about threading
            //_sortedProducts.value =
            //    productsRepository.loadSortedProducts(ascending)

            if (parrotList == null) {
                parrotList = repository.getParrots()
            }

            val randomParrot = parrotList!![Random.nextInt(0, parrotList!!.size - 1)]
            Log.i("MainViewModel", randomParrot.toString())

            _randomParrot.value = randomParrot
        }
    }
}