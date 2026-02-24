function multiplyNumeric(obj) {
    for (let i in obj) {
        obj[i] *= 2
    }
}

let numbers = {
    num1: 100,
    num2: 2
}

console.log(numbers)
multiplyNumeric(numbers)
console.log(numbers)