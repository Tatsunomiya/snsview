package tatsunomiya.com.snsviewr

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import tatsunomiya.com.snsviewr.Bootsfragment
import tatsunomiya.com.snsviewr.Eyeglassfragment
import tatsunomiya.com.snsviewr.Garagefragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val fragmentList = arrayListOf<Fragment>(
            Bootsfragment(),
            Eyeglassfragment(),
            Garagefragment()
        )
        /// adapterのインスタンス生成
        val adapter = PagerAdapter(supportFragmentManager, fragmentList)
        /// adapterをセット
        viewPager.adapter = adapter

        nextPageBtn.setOnClickListener {
            // ページを1つ進める
            viewPager.currentItem += 1
        }
        prevPageBtn.setOnClickListener {
            // ページを1つ戻す
            viewPager.currentItem -= 1
        }

        prevPageBtn.isVisible = false

        /// スクロール中の変更処理
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            /// implementする
            override fun onPageSelected(position: Int) {
                /// btnの表示制御（端では表示しない）
                prevPageBtn.isVisible = position != 0
                nextPageBtn.isVisible = position != fragmentList.size - 1


                when (position) {
                    0 -> {
                        jumpbutton.setOnClickListener {


                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/?hl=ja"))

                            startActivity(intent)
                        }


                    }

                    1 -> {
                        jumpbutton.setOnClickListener {


                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ameblo.jp/"))

                            startActivity(intent)
                        }
                    }


                    2 -> {
                        jumpbutton.setOnClickListener {


                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))

                            startActivity(intent)
                        }

                    }
                    else -> {
                        // 上記のcase文に入らなかった場合の処理}
                    }
                }

            }




            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
        })
    }
}


