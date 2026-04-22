let arr = []

for (let i = 0; i < 5; i++) {
    arr.push(Math.floor(Math.random() * 100) + 1)
}
console.log(arr)

let max = Math.max(...arr)
let min = Math.min(...arr)

let maxIndex = arr.indexOf(max);
let minIndex = arr.indexOf(min);

[arr[maxIndex], arr[minIndex]] = [arr[minIndex], arr[maxIndex]]
console.log(arr)
