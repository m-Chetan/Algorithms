/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
    l1 := []int{}
    getLeaves(root1, &l1)
    
    l2 := []int{}
    getLeaves(root2,&l2)
    
    return reflect.DeepEqual(l1,l2)
}


func getLeaves(root *TreeNode, leaves *[]int){
    if root==nil {
        return
    }
    if root.Left==nil && root.Right==nil{
        *leaves = append(*leaves,root.Val)
        return
    }
    
    getLeaves(root.Left,leaves)
    getLeaves(root.Right,leaves)
}