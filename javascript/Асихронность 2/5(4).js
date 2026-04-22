function addNumbers(a,b) {
    return new Promise((resolve, reject) => {
        if (a === undefined || b === undefined) {
            reject("Числа не определены")
        } else if (typeof a !== 'number' || typeof b !== 'number') {
            reject("Должны быть введены числа")
        } else {
            resolve(a + b)
        }
    }
    )
}

async function sumFunction(A, B, maxOperations = 5) {
    let a = A
    let b = B
    let operationsCount = 0

    console.log(a + " + " + b)
    
    function delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms))
    }
    
    for (let i = 0; i < maxOperations; i++) {
        try {
            if (i > 0) {await delay(2000)}
            
            sum = await addNumbers(a, b)
            operationsCount++
            console.log("Операция " + operationsCount + ": " + a + " + " + b + " = " + sum)
            a = sum
            
        } catch (error) {
            console.log(error)
            return
        }
    }
    
    console.log("Итоговая сумма: " + a)
}

sumFunction(1, 2)

setTimeout(function() { 
    sumFunction(1, "два")}, 13000)