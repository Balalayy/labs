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

function sumFunction(A, B, maxOperations = 5) {
    let a = A
    let b = B
    let operationsCount = 0

    console.log(a + " + " + b)
    
    function nextOperation() {
        addNumbers(a, b)
        .then(function(sum) {
            operationsCount++
            console.log("Операция " + operationsCount + ": " + a + " + " + b + " = " + sum)
            a = sum

            if (operationsCount >= maxOperations) {
                console.log("Итоговая сумма: " + a)
            } else {
                setTimeout(nextOperation, 2000)
            }
        })
        .catch(function(error) {
            console.log(error)
        })
    }
    setTimeout(nextOperation, 2000)
}

sumFunction(1, 2)

setTimeout(function() { 
    sumFunction(1, "два")}, 13000)