let animal = {
    jumps: null
};
let rabbit = {
    __proto__: animal,
    jumps: true
};
console.log(rabbit.jumps); // ? (1)

delete rabbit.jumps;

console.log(rabbit.jumps); // ? (2)

delete animal.jumps;

console.log(rabbit.jumps); // ? (3)

/* Показываются значения:
true
null
undefined

true - изначальное значение jumps
null - у jumps пропадает значение
undefined - исчезает само свойство jumps
*/