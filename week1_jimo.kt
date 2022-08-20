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
class Person constructor(name: String, age: Int){
    //private
    private var _name: String
    private var _age: Int
    private var _has_car: Boolean//항상 체크해야된다는점 주의
    private var _car: Car//default로 setting된다는점 주의
    
    private inner class Car(which_car: Boolean){
        private var is_run: Boolean=false
        fun run(){
            if(is_run==true){
                println("[${_name}] Your car is already running!")
                return
            }
            println("[${_name}] Your car is running now!")
            is_run=true
        }
        fun stop(){
            if(is_run==false){
                println("[${_name}] Your car is already stoped!")
                return
            }
            println("[${_name}] Your car is stopped!")
            is_run=false
        }
    }
    
   //public
    init{
         _name=name
         _age=age
         _has_car=false
         _car=Car(false)
        println("Create New User(name: ${name}, age: ${age})!")
   }
    
    public fun purchase_car(which_car: Boolean){
        if (_has_car==true){
            println("[${_name}] You already has Car! cannot buy more car")
            return
        }
        println("[${_name}] You buy '${which_car}' car!")
        _car=Car(which_car)
        _has_car=true
    }

    public fun make_run_car(){
        if(_has_car==false){
            println("[${_name}] You have to buy a car first!")
            return
        }
        _car.run()
    }

    public fun make_stop_car(){
        if(_has_car==false){
            println("[${_name}] You have to buy a car first!")
            return
        }
        _car.stop()
    }
}

fun main(){
    var one:Person=Person("choi", 22)
    var two:Person=Person("tae", 28)
    one.make_run_car()
    one.purchase_car(true)
    one.make_stop_car()
    two.purchase_car(false)
    one.make_run_car()
    two.make_run_car()
    one.make_stop_car()
    one.purchase_car(false)
}