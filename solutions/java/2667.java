/*
 * Leetcode 2667: Create Hello World Function. JavaScript. Easy.
 * O(1) runtime and O(1) space complexity.
 * The problem is solved by returning a higher-order function that, when invoked,
 * returns the string "Hello World". This leverages JavaScript's first-class functions 
 * and closures to achieve the desired behavior.
 * 12/2/2024 Winston Tsui
 */

/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {   
        return "Hello World";
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
