function isEmpty(obj) {
    for (let i in obj) {
        return false
    }
    return true
}

let obj1 = {}
console.log(isEmpty(obj1))

let obj2 = {name: "John"}
console.log(isEmpty(obj2))