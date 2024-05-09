for (int i = 0; i < 5; i++) {
    println "Iteration: ${i}"
}

def names = ['John', 'Jane', 'Jim']
for (name in names) {
    println name
}

def ages = ['John': 30, 'Jane': 25, 'Jim': 35]
for (entry in ages) {
    println "${entry.key} is ${entry.value} years old"
}

def names2 = ['John', 'Jane', 'Jim']
names2.each { name ->
    println name
}

def ages2 = ['John': 30, 'Jane': 25, 'Jim': 35]
ages2.each { key, value ->
    println "$key is $value years old"
}

5.times { i ->
    println "Iteration: ${i}"
}


def x = 0
while (x < 5) {
    println "Iteration: ${x}"
    x++
}

def y = 0
do {
    println "Iteration: ${y}"
    y++
} while (y < 5)


