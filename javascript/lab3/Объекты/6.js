let calculator = {
    a: 0,
    b: 0,

    read(a, b) {
        this.a = a
        this.b = b
    },

    sum() {
        return this.a + this.b
    },

    mul() {
        return this.a * this.b
    }
}

calculator.read(2, 3)
console.log(calculator.a, calculator.b)
console.log(calculator.sum())
console.log(calculator.mul())