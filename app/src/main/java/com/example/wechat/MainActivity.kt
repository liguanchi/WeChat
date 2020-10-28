package com.example.wechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    fun initFruitList(){
        repeat(1){
            Int
            fruitList.add(Fruit(R.drawable.wechat1,"徐顺瑜","菠萝卖"))
            fruitList.add(Fruit(R.drawable.wechat2,"池","烧卖"))
            fruitList.add(Fruit(R.drawable.wechat3,"阿龙","啊"))
            fruitList.add(Fruit(R.drawable.wechat4,"阿威","哦"))
            fruitList.add(Fruit(R.drawable.wechat5,"坤","噢"))
            fruitList.add(Fruit(R.drawable.wechat6,"晓哥","1111"))
            fruitList.add(Fruit(R.drawable.wechat1,"aaa","222"))
            fruitList.add(Fruit(R.drawable.wechat2,"aaa","333"))
            fruitList.add(Fruit(R.drawable.wechat3,"aaa","444"))
            fruitList.add(Fruit(R.drawable.wechat4,"aaa","555"))
            fruitList.add(Fruit(R.drawable.wechat5,"aaa","666"))
            fruitList.add(Fruit(R.drawable.wechat6,"aaa","777"))
            fruitList.add(Fruit(R.drawable.animal_0,"aaa","888"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//去掉标题

        initFruitList()

        val fruitAdapter = FruitAdapter(this,R.layout.fruit_item,fruitList)

        listViewTest.adapter = fruitAdapter

        listViewTest.setOnItemClickListener { _, _, i, _ ->
            val fruit = fruitList[i]
            Toast.makeText(this,fruit.fruitTitle,Toast.LENGTH_SHORT).show()
        }



    }
}
