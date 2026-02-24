function Rabbit() {}
Rabbit.prototype = {
    eats: true
};

let rabbit = new Rabbit();

delete Rabbit.prototype.eats;

console.log(rabbit.eats); // true

/*
Rabbit.prototype = {}; - true
новый прототип влияет только на новые объекты

Rabbit.prototype.eats = false; - false
значение eats изменилось на false

delete rabbit.eats; - true
eats принадлежит прототипу Rabbit, а не объекту rabbit

delete Rabbit.prototype.eats; - undefined
свойство eats удалено в прототипе
*/