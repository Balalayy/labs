function funcfx(x, i, callback) {
 return new Promise((resolve) => {
        setTimeout(() => {
            let result;
            if (i === 1) result = x * x;          
            else if (i === 2) result = 2 * x;     
            else if (i === 3) result = -2;         
            else if (i === 4) result = 3;         
            else if (i === 5) result = x;          
            else if (i === 6) result = 5;         
            else result = 0;
            
            console.log('f' + i + '(' + x + ') = ' + result);
            resolve(result);
        }, Math.floor(Math.random() * 500));
    });
}

function calculateF(x, n, callback) {
    let currentStep = 1;
    let intermediateResult = 0;
    
    function nextStep() {
        if (currentStep <= n) {
            return funcfx(x, currentStep).then((value) => {
                intermediateResult += value;
                console.log('Промежуточный результат ' + currentStep + ': ' + intermediateResult);
                currentStep++;
                return nextStep(); 
            });
        } else {
            console.log('Итоговый результат F(' + x + ') = ' + intermediateResult)
            return Promise.resolve(intermediateResult);
        }
    }
    
    return nextStep();
}

async function tests() {
    console.log("n = 2");
    await calculateF(3, 2);
    
    console.log("\nn = 4");
    await calculateF(3, 4);
    
    console.log("\nn = 6");
    await calculateF(3, 6);
}

tests();