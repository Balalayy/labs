let animal = {
    eat() {
        this.full = true;
    }
};

let rabbit = {
    __proto__: animal
};

rabbit.eat();
console.log(rabbit.full) // "true" - rabbit получил свойство
console.log(animal.full) // "undefinde" - animal не получил