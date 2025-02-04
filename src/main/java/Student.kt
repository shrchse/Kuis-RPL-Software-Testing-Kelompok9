
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

// ID yang memiliki tipe data INT dan hanya diisi bilangan bulat Contoh : 5
// Nama bertipe String, Contoh : Joko Tarbiah
// Tanggal lahir bertipe String, contoh : 10 Agustus 2019
// fungsi yang mengubah format tanggal lahir menjadi standar tanggal dd-mm-yyyy. Contoh : 10-08-2019
// Nomor handphone bertipe String yang memiliki syarat minimal panjang huruf 11 dan maksimal 12

class Student {
    private var id: Int = 0
    private lateinit var name: String
    private lateinit var birthday: String
    private lateinit var phoneNumber: String

        fun setId(id: Int){this.id = id}
        private fun getId() = this.id
        fun setName(name: String){this.name = name}
        private fun getName() = this.name
        fun setBirthday(birthday: String){this.birthday = birthday}
        fun setPhoneNumber(phoneNumber: String){this.phoneNumber = phoneNumber}
/*
    constructor(id: Int, name: String, birthday: String, phoneNumber: String) : this(){
        this.id = id
        this.name = name
        this.birthday = birthday
        this.phoneNumber = phoneNumber
    }
*/

    fun identity(): String {
        return "${getId()} ${getName()} ${getBirthday()} ${getphoneNumber()}"
    }

    fun getphoneNumber(): String {
        return if (phoneNumber.length == 11 || phoneNumber.length == 12) {
            phoneNumber
        } else return "Number Invalid"
    }

    fun getBirthday(): String? {
        val inDate = birthday
        val formating = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("in", "ID"))
        val inDateFormated = LocalDate.parse(inDate, formating)

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale("in", "ID"))
        return inDateFormated.format(formatter)
    }
    //  Orang tua bertipe Object yang berisi String nama kedua orang tua.
    //  Contoh : {"ayah" : "Stephen Sambura", "Ibu" : "Stephani Sambruang"}

    class Parent(private var ayah: String, private var ibu: String){
        private fun getAyah() = this.ayah
        private fun getIbu() = this.ibu
        fun show (): String {
            return("${getAyah()}, ${getIbu()}")
        }
    }

    /*NIM yang memiliki tipe data String yang bersifat OTOMATIS di generate saat pembuatan object Student
    dan merupakan kode yang berupa gabungan ID, huruf pertama dan akhir dari nama student,
    dan tanggal lahir : Contoh ID=5, nama : Joko Tarbiah,
    Tanggal Lahir : 10 Agustus 2019.
    NIM nya menjadi : 5JT10082019
    */
    fun generateNIM(): String {
        val init: String = getName().trim().split(" ").map{it.first()}.joinToString("").uppercase()
        val birthday = getBirthday()
        val generateNumber = birthday?.replace("-","")

        return "${getId()}$init$generateNumber"
    }
    /* Hobi yang bertipe array atau list atau arraylist yang berisikan string
       contoh : ['Bersepeda', 'Bernyanyi', 'Makan'] */

    fun hobbies(): String {
        val hobi: Array<String> = arrayOf("Minum Coklat Panas ", "Bermain Tictactoe ", "Bermain Permainan Papan ")
        val stringBuilder = StringBuilder()
        for (i in hobi) {
            stringBuilder.append(i).append(", ")
        }
        return stringBuilder.toString().substring(0, stringBuilder.length - 2)
    }
   /*
    * sebuah fungsi yang dapat mengembalikan nilai berbentuk ArrayList dengan tipe data Object Student
    * */
    fun getListStudent(): ArrayList<Student> {
       val listStudent = ArrayList<Student>()
       listStudent.add(Student())
       for (each in listStudent){
           return listStudent
       }
       return listStudent
    }
}
