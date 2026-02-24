function calculator() {
    this.a = 0
    this.b = 0

    this.read = function(a, b) {
        this.a = a
        this.b = b
    }

    this.sum = function() {
        return this.a + this.b
    }

    this.mul = function() {
        return this.a * this.b
    }
}

let calc = new calculator
calc.read(10, 5)
console.log(calc.sum(), calc.mul())