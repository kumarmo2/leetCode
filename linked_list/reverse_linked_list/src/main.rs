struct Solution {}
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}
impl Solution {
    pub fn reverse_list(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        match head {
            None => None,
            Some(ref val) => {
                if let None = val.as_ref().next {
                    return head;
                } else {
                    let mut prev: Option<&Box<ListNode>> = None;
                    let mut curr = head.as_ref();
                    loop {
                        match curr {
                            None => {
                                let x = prev.unwrap();
                            }
                        }
                    }
                }
            }
        }
    }
}

fn main() {
    println!("Hello, world!");
}
