function nangle(points) {
    let perimeter = 0
    for (let i = 0; i < points.length; i++) {
        point1 = points[i]
        point2 = points[(i + 1) % points.length]
        perimeter += Math.sqrt((point2.x - point1.x) ** 2 + (point2.y - point1.y) ** 2)
    }
    return perimeter
}

figure1 = [{x:0,y:0}, {x:3,y:0}, {x:0,y:4}]
figure2 = [{x:0,y:0}, {x:2,y:0}, {x:2,y:2}, {x:0,y:2}]
figure3 = [{x:1,y:1}, {x:5,y:1}, {x:5,y:4}, {x:1,y:4}]

console.log(nangle(figure1))
console.log(nangle(figure2))
console.log(nangle(figure3))