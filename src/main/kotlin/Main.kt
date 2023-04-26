fun main() {
    //testes
    println(mmc(10,12))
    println(mdc(10,12))
    println(mdc(12,15))
    println(mdc(20,50))
    println(mdc(20,24))
    println(mdc(-1,5))
    println(mdc(2,0))
    println(mdc(1,3))
}

fun mmc(n1:Int, n2:Int):Int{
    var divisor = 2 //começa no 2 porque quando fazemos no papel começamos do 2
    var novon1 = n1
    var novon2 = n2
    if(novon1==1 && novon2==1){
        return 1
    } else {
        while (novon1 % divisor != 0 && novon2 % divisor != 0) { //encontra o menor divisor para pelo menos algum dos números
            ++divisor
        }
        if (novon1 % divisor == 0) { //se n1 for divisível pelo divisor encontrado, realiza-se a divisão
            novon1 /= divisor
        }
        if (novon2 % divisor == 0) { //se n2 for divisível pelo divisor encontrado, realiza-se a divisão
            novon2 /= divisor
        }
        return divisor * mmc(novon1, novon2)
    }

}

fun mdc(n1: Int,n2: Int):Int{
    var divisor = 2 //começa no 2 porque quando fazemos no papel começamos do 2
    var novon1 = n1
    val testeDivisaoN1:Boolean
    var novon2 = n2
    val testeDivisaoN2:Boolean
    var numMdc :Int
    if(novon1<=0 || novon2<=0){
        return 0
    } else {
        if (novon1 != 1 && novon2 != 1) {
            while (novon1 % divisor != 0 && novon2 % divisor != 0) { //encontra o menor divisor para pelo menos algum dos números
                ++divisor
                numMdc = divisor
            }
            if (novon1 % divisor == 0) { //se n1 for divisível pelo divisor encontrado, realiza-se a divisão
                novon1 /= divisor
                testeDivisaoN1 = true //se for divisível, é salvo true
            } else {
                testeDivisaoN1 = false //senão false
            }
            if (novon2 % divisor == 0) { //se n2 for divisível pelo divisor encontrado, realiza-se a divisão
                novon2 /= divisor
                testeDivisaoN2 = true //se for divisível, é salvo true
            } else {
                testeDivisaoN2 = false //senão false
            }
            if (testeDivisaoN1 && testeDivisaoN2) { //se for divisível pelos 2 números
                return divisor * mdc(
                    novon1,
                    novon2
                ) //(divisor que dividiu esses números atuais) * (o último divisor que dividiu todos os números)
            } else {
                return mdc(novon1, novon2) // o último divisor que dividiu todos os números
            }
        } else {
            return 1
        }
    }
}