#![allow(dead_code)]

use std::io;

struct Person {
    name: String,
}

fn borrow_person(person: &Person) {
    println!("name: {}", person.name);
}

struct LlNode {
    val: i32,
    next: Option<Box<LlNode>>,
}

impl LlNode {
    fn new(val: i32) -> LlNode {
        LlNode { val, next: None }
    }
}

fn create_ll(arr: &Vec<i32>) -> Option<Box<LlNode>> {
    let mut head = Box::new(LlNode::new(arr[0]));
    let mut curr = &mut head;
    let mut i = 1;
    while i < arr.len() {
        curr.next = Some(Box::new(LlNode::new(arr[i])));
        let a = curr.next.as_mut();
        let b = a.unwrap();
        curr = b;
        i = i + 1;
    }
    return Some(head);
}

fn main() {
    println!("Hello world");
    let person = Box::new(Person {
        name: "mohit".to_string(),
    });
    borrow_person(&person);
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let v: Vec<i32> = input
        .split_whitespace()
        .map(|n| n.parse::<i32>().unwrap())
        .collect();
    println!("v: {:?}", v);
    let curr = create_ll(&v);
    let mut curr_ref = curr.as_ref();
    loop {
        match curr_ref {
            Some(a) => {
                println!("val: {}", a.val);
                curr_ref = a.next.as_ref();
            }
            None => {
                println!("khatam");
                break;
            }
        }
    }
}
