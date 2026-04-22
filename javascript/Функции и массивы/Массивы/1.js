let arr = []

arr[0] = 1
arr[1] = 10
arr[2] = 100

console.log("Индекс 2:", arr[2])

console.log("Длина массива", arr.length)

arr.splice(1,1)

console.log("Массив после удаления:")
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i])
}