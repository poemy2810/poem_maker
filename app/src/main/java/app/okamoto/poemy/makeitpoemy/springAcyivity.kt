package app.okamoto.poemy.makeitpoemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class springAcyivity : AppCompatActivity() {

    val springList = arrayOf("桜", "卒業", "団子", "出会い", "入学")
    val springList2 = arrayOf("桜もち", "花見", "鯛焼き", "梅", "如月")
    val springList3 = arrayOf("学校", "屋上", "入学式", "机", "黒板", "チョーク")


    var whenIndex2 = 0
    var whoIndex2 = 0
    var whereIndex2 = 0
    var keywordIndex2 = 0


    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring)

        val whenImageList2 =
            arrayOf(R.drawable.morning, R.drawable.noon, R.drawable.evening, R.drawable.night)
        val whoImageList2 =
            arrayOf(R.drawable.friend, R.drawable.couple, R.drawable.pet, R.drawable.parents)
        val whereImageList2 = arrayOf(R.drawable.hanami, R.drawable.kyoto, R.drawable.school)
        val keywordImageList2 = arrayOf(
            arrayOf(R.drawable.alchol, R.drawable.dango, R.drawable.kaidashi),
            arrayOf(R.drawable.kamogawa, R.drawable.kiyomizudera, R.drawable.shinkansen),
            arrayOf(R.drawable.graduation, R.drawable.randoseru, R.drawable.teacher)


        )



        whenButton.setOnClickListener {
            whenIndex2 = Random.nextInt(whenImageList2.size)
            whenImage.setImageResource(whenImageList2[whenIndex2])
        }

        whoButton.setOnClickListener {
            whoIndex2 = Random.nextInt(whoImageList2.size)
            whoImage.setImageResource(whoImageList2[whoIndex2])
        }

        whereButton.setOnClickListener {
            whereIndex2 = Random.nextInt(whereImageList2.size)
            whereImage.setImageResource(whereImageList2[whereIndex2])
        }

        keywordButton.setOnClickListener {
            keywordIndex2 = Random.nextInt(keywordImageList2[whereIndex2].size)
            keywordImage.setImageResource(keywordImageList2[whereIndex2][keywordIndex2])
        }

        saveButton.setOnClickListener {
            //editText.text = editText.text
            create("spring: ", editText.text.toString())
        }

        /*appdataButton.setOnClickListener {

                val randomnum = Random.nextInt(springList.size)
                textView.text = springList[randomnum]

                val randomnum2 = Random.nextInt(springList2.size)
                textView2.text = springList2[randomnum2]

                val randomnum3 = Random.nextInt(springList3.size)
                textView3.text = springList3[randomnum3]


                //val summerViewRandom = Random.nextInt(summerViewList.size)
                //summerView.setImageState() = summerViewList[summerViewRandom]

            }

        returnButton.setOnClickListener {

            val intent2: Intent = Intent(this, choiceActivity::class.java)
            startActivity(intent2)

        }*/

    }

        fun create(season: String, content: String) {
            realm.executeTransaction {
                val poem = it.createObject(Poem::class.java, UUID.randomUUID().toString())
                poem.season = season
                poem.content = content
            }
        }



}

