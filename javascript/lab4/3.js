function funcfx(x, i, callback) {
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
        callback(result);
    }, Math.floor(Math.random() * 500)); 
}

function calculateF(x, n, callback) {
    let currentStep = 1;
    let intermediateResult = 0;
    
    function nextStep() {
        if (currentStep <= n) {
            funcfx(x, currentStep, function(value) {
                intermediateResult += value;
              console.log('Промежуточный результат ' + currentStep + ': ' + intermediateResult);
                currentStep++;
                nextStep(); 
            });
        } else {
            console.log('Итоговый результат F(' + x + ') = ' + intermediateResult)
            callback(intermediateResult);
        }
    }
    
    nextStep();
}

function tests() {

    console.log("n = 2");
    calculateF(3, 2, function() {
        setTimeout(() => {

            console.log("n = 4");
            calculateF(3, 4, function() {
                setTimeout(() => {

                    console.log("n = 6");
                    calculateF(3, 6, function() {
                    });
                }, 500);
            });
        }, 500);
    });
}


tests()