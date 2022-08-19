class Client {
    String name;
    int age;
    int money=0;
    String carname;

    private void setName(String name){
        this.name=name;
    };
    private void setAge(int age){
        this.age=age;
    };
    private void buyCar(String carname){
        this.carname=carname;
        System.out.print(this.carname+"을(를) 구매했다!");
    };

}
