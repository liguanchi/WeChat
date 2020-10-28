package com.example.wechat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ninepatchdemo.Msg
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.bottom.*
import java.util.ArrayList

class ChatActivity : AppCompatActivity() {
    private var msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        //数据初始化
        initMsgData()

        val layoutManager = LinearLayoutManager(this)
        RecyclerViewTest.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }

//        //为适配器添加缩放动画
//        val adapter1 = ScaleInAnimationAdapter(adapter).apply {
//            //设置动画时长
//            setDuration(500)
//        }
//        //叠加上面的动画，添加下移出动画
//        val adapter2 = SlideInBottomAnimationAdapter(adapter1).apply {
//            setDuration(300)
//        }

        RecyclerViewTest.adapter = adapter

//        滚动到最新数据的位置上
        RecyclerViewTest.scrollToPosition(msgList.size - 1)

        msgSend.setOnClickListener {
            val text: String = msgText.text.toString()

            if (text.isNotEmpty()) {
                val list: List<Msg> = adapter.getList()
                if (msgList.size != list.size) msgList = list as ArrayList<Msg>
                //增加数据到数据源
                val msg = Msg(text, R.drawable.img_5, Msg.TYPE_RIGHT)
                msgList.add(msg)
                //通知适配器增加了数据
                adapter.notifyItemInserted(msgList.size - 1)
                //滚动到最新数据的位置上
                RecyclerViewTest.scrollToPosition(msgList.size - 1)
                //清空输入框的内容
                msgText.setText("")
            }
        }


        rootLayout.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            if (oldBottom != -1 && oldBottom > bottom) {
                RecyclerViewTest.requestLayout()
                RecyclerViewTest.post { RecyclerViewTest.scrollToPosition(msgList.size - 1) }
            }
        }


    }


    private fun initMsgData() {
        repeat(2)
        {
            msgList.add(
                Msg(
                    "两个include的高度拉不动",
                    R.drawable.img_1,
                    0
                )
            )
            msgList.add(
                Msg(

                    "一直是占满界面",
                    R.drawable.img_1,
                    0
                )
            )
            msgList.add(
                Msg(
                    "直接在界面用控件试试",
                    R.drawable.img_5,
                    Msg.TYPE_RIGHT
                )
            )
            msgList.add(
                Msg(

                    "可以拖了",
                    R.drawable.img_1,
                    0
                )
            )
            msgList.add(
                Msg(
                    "啥也没搞，突然又能拖动了。。",
                    R.drawable.img_4,
                    0
                )
            )
            msgList.add(
                Msg(
                    "让人怪不好意思的",
                    R.drawable.img_7,
                    0
                )
            )
            msgList.add(
                Msg(
                    "为啥一点打字会吃掉一点",
                    R.drawable.img_6,
                    0
                )
            )
            msgList.add(Msg("测试看看 下面的区域如果是一个整体，设置一点的Top内边距", R.drawable.img_5, 1))
        }
    }


    /*
    *  override fun onClick(v: View) {
        when (v) {
            msg_sendout -> {
                val str = weChat_txt.text.toString()
                if (str.isNotEmpty()) {
                    val msg = Msg(str, Msg.TYPE_RIGHT, R.drawable.img_5)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1)
                    RecyclerViewTest.scrollToPosition(msgList.size - 1)
                    weChat_txt.setText("")
                }
            }
        }
    }
    * */


}