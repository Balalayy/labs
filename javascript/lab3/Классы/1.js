class Clock {
    constructor(h, m, s) {
        this.hours = h
        this.minutes = m
        this.seconds = s
    }

    display() {
        console.log(this.hours+ ":" +this.minutes+ ":" +this.seconds)
    }
}

let clock = new Clock(15, 30, 10)
clock.display()