from b_tree_node import TreeNode

"""
 搜索二叉树使用链表实现 
 搜索二叉树特点
 它的左右子树也分别为二叉搜索树 举个例子 
     8
   /  /
  3  10
  8是根节点 3是左子树 10是右子树 3也是搜索二叉树 以此循环
 左子树的所有节点的值均小于它的根节点的值
 右子树的所有节点的值均大于它的根节点的值
 优点 在二叉树平衡的状态下 插入删除修改都很快
 时间复杂度为O(logn) 
"""


class BinarySearchTree:

    def __init__(self, root: TreeNode = None) -> None:
        self.root = root

    def __str__(self) -> str:
        return self.root.value

    def search(self, value) -> TreeNode:
        return self._search(self.root, value=value)

    def remove(self, value):
        return self._remove(self.root, value=value)

    def insert(self, key):
        self._insert(self.root, key)
        
    def in_order(self, root:TreeNode):
        if root is not None:
            self.in_order(root=self.root.left)
            print(self.root.value)
            self.in_order(root=self.root.right)

    def per_oder(self, root):
        if root is not None:
            print(self.root.value)
            self.per_oder(self.root.left)
            self.per_oder(self.root.right)

    def post_oder(self, root):
        if root is not None:
            self.per_oder(self.root.left)
            self.per_oder(self.root.right)
            print(self.root.value)

    # 插入节点
    def _insert(self, current_root: TreeNode, key):
        if current_root is None:  # 如果root为空
            self.root = TreeNode(value=key)  # 新建一个根节点
            return True
        if key < current_root.value:  # 如果key<current_root的值 那就说明key是左子树的元素
            if current_root.left is None:  # 如果左子树为空
                current_root.left = TreeNode(key)  # 新建一个左子树
            else:  # 如果左子树不为空
                current_root.left = self._insert(
                    current_root=current_root.left, key=key)  # 使用递归把元素插入到左子树
        elif key > current_root.value:  # 如果key>current_root的值 那就说明key是右子树的元素
            if current_root.right is None:  # 如果右子树为空
                current_root.right = TreeNode(key)  # 新建右子树
            else:  # 如果右子树不为空
                current_root.right = self._insert(
                    current_root=current_root.right, key=key)  # 使用递归把元素插入到右子树

    # 关键思路找到要删除节点的右子树的最小值，代替要删除节点的数据并递归的删除那个数据
    # 这样才能保证搜索二叉树的性质
    def _remove(self, root: TreeNode, value):
        if root is None:
            return None
        if value < root.value:  # 如果value 小于根节点
            root.left = self.__remove(root=root.left, value=value)
        elif value > root.value:  # 如果value 大于根节点
            root.right = self.__remove(root=root.right, value=value)
        else:  # 如果value等于根节点
            if root.left == None:  # 如果根节点的左子树为空
                return root.right  # 返回根节点的右子树
            elif root.right == None:  # 如果根节点的右子树为空
                return root.left  # 返回根节点的左子树
            min_node = self.find_min(root.right)  # 找到右子树中的最小节点
            root.value = min_node.value  # 将其值赋给root节点
            root.right = self.__remove(
                root=root.right, value=root.value)  # 递归删除
        return root

    # 查找搜索二叉树的值
    # 思路使用递归查找
    def _search(self, root: TreeNode, value):
        if root is None or root.value == value:  # 判断二叉树是否为空 或者 当前值是否等于递归的值 或者 当前值等于根节点
            return root  # 返回结果
        if root.value < value:  # 如果要查找的值大于根节点的值 说明这个值是右子树的节点 否则这个值是左子树的节点
            return self.__search(root.left, value=value)  # 递归查找左子树
        return self.__search(root=root.right, value=value)  # 递归查找右子树

    def find_max(self) -> TreeNode:
        cur = self.root

        while cur.right is not None:  # 遍历二叉树的右子树找到最大值
            cur = cur.right  # 向下查找

        return cur  # 返回最大值

    def find_min(self) -> TreeNode:
        cur = self.root

        while cur.left is not None:  # 遍历二叉树的左子树找到最小值
            cur = cur.left  # 向下查找

        return cur  # 返回最小值


if __name__ == '__main__':
    tree = BinarySearchTree()
    node=TreeNode(1)
    tree._insert()
