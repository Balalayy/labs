function u(x, y, z) {
    console.log(Math.max(x, y) + Math.max(x + y, z)) / Math.pow(Math.max(0.5, x + z), 2)
}

u(1, 2, 3)
u(64, 69, 67)
u(100, 5, 99)