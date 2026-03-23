let promise = new Promise(function(resolve, reject) { // создаётся promise
    resolve(1); // promise заполняется значением 1

    setTimeout(() => resolve(2), 1000); // через секунду promise попытается заполниться значением 2
    }); 
    
promise.then(console.log); // но выводится значение 1, так как promise уже завершён, а повторный resolve игнориуется