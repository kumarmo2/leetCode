use std::io;
struct Solution {}

impl Solution {
    pub fn is_valid(input: String) -> bool {
        let mut s: Vec<char> = Vec::new();
        for c in input.chars() {
            if c == '(' || c == '{' || c == '[' {
                s.push(c);
            } else {
                if s.len() < 1 {
                    return false;
                }
                let opening_bracket = s.pop().unwrap();
                if c == ')' {
                    if opening_bracket != '(' {
                        return false;
                    }
                } else if c == '}' {
                    if opening_bracket != '{' {
                        return false;
                    }
                } else {
                    if opening_bracket != '[' {
                        return false;
                    }
                }
            }
        }
        if s.len() > 0 {
            return false;
        }
        true
    }
}
fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input = input.trim().to_string();
    println!("{}", Solution::is_valid(input));
}
