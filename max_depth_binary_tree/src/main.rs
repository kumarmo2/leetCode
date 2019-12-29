#![allow(dead_code)]
use std::cell::RefCell;
use std::cmp;
use std::rc::Rc;

pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
    match root {
        // Some(node: &Rc<RefCell<TreeNode>>) => {
        Some(node) => {
            let mut lh = 0;
            let mut rh = 0;
            if let Some(ref x) = node.borrow().left {
                lh = max_depth(Some(Rc::clone(x)));
            }
            if let Some(ref y) = node.borrow().right {
                rh = max_depth(Some(Rc::clone(y)));
            }
            1 + cmp::max(lh, rh)
        }
        None => 0,
    }
}

fn main() {
    println!("Hello, world!");
}
