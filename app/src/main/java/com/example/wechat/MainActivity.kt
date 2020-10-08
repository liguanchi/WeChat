package com.example.wechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    fun initFruitList(){
        repeat(1){
            Int
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","菠萝卖"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//去掉标题

        initFruitList()

        val fruitAdapter = FruitAdapter(this,R.layout.fruit_item,fruitList)

        listViewTest.adapter = fruitAdapter



    }
}
