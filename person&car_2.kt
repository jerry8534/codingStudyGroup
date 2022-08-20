import kotlin.properties.Delegates

/*
기획서
1. 사람이 있다.
2. 사람은 이름과 나이, 구매(행위)를 할 수 있다.
3. 자동차가 있다._자동차 추상화->클래스표현
4. 자동차의 종류는 2가지(임의)로 한다.
5. 사람은 자동차를 구매할 수 있다.
6. 돈(가격)은 없다고 가정한다.
7. 한 사람은 하나의 자동차만 구매할 수 있다.
8. 사람은 여러명일 수 있다.
9. 자동차는 출발하거나 정지할 수 있다.
*/
abstract class Vehicle{
    abstract fun go()
    abstract fun stop()
}

class Car(whichCar: String): Vehicle() {
    companion object{
        val carCategory = listOf<String>("Hyundai", "Kia")//차는 두종류로 한정.
    }
    var carName:String="null"
    init{
        if(whichCar in carCategory || whichCar=="null"){
             carName=whichCar
        } else{
            println("Wrong car name!")
            carName="null"
        }
    }

    override fun go(){
        if(carName=="null") {
            println("Make car first!")
            return
        }

        println("$carName go!")
    }

    override fun stop(){
        if(carName=="null") {
            println("Make car first!")
            return
        }
        println("$carName stop!")
    }
}

open class basicInformation(name: String, age: Int){
    protected var _name=name
    protected var _age=age

    protected fun printBasicInformation(){
        println("name is $_name, age is $_age")
    }
}

interface Purchaseable{
    fun purchase(name: String)
}

class Person constructor(name: String, age: Int): basicInformation(name, age), Purchaseable{
    var has_car=false
    var car:Car=Car("null")

    override fun purchase(name: String) {
        if(car.carName!="null"){
            println("you already have a car!")
            return
        }

        car=Car(name)
        if(car.carName!="null"){
            println("success for purchase $name!")
        }else{
            println("fail to purchase a car!")
        }
    }

}

fun main(){
    var one=Person("choi", 22)
    var two=Person("tae", 28)

    one.car.go()
    one.purchase("Kia")
    one.car.go()
}