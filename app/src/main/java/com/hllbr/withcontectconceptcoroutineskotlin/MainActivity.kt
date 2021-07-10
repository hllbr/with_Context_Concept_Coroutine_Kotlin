package com.hllbr.withcontectconceptcoroutineskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
Bu yapıda bir Dispatchers yapıdan diğerine geçerken ne yapılacağı ile ilgili bir durum
 */
main()
    }

    fun main(){
        //Bir launc içersinde diğerine referans vermemizi sağlayan bir yapı .Bu sayede aynı Scope içersinde farklı  threadler ile işlemler yaptırmaya çalışılabilir
        //Bu genelde Dispatchers.IO ile başlayıp Dispatchers.Main ile biter örneklerde bu şekilde karşılaşırız.
        //Şuan bu örneği yapmadık çünkü Ma.n Dispatchers yok elimizde
        //Retrofit ile çalışırken bu yapı karşımıza çıkacaktır.
        

        runBlocking {
            launch(Dispatchers.Default) {
                //Default ile bir işlem yapacağım ve başka bir yere geçeceğim.
                println("CONTEXT = ${coroutineContext}")
                withContext(Dispatchers.IO){
                    println("CONTEXT = ${coroutineContext}")
                }
            }
        }
    }
}