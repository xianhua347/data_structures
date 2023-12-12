from b_tree_node import TreeNode, T


class BiTree:
    def __init__(self, root) -> None:
        self.root = root

    def __init__(self) -> None:
        self.root = None

    # 先序遍历
    def pre_oder(self, node: TreeNode[T]):
        if node:
            yield from print("data"+node+"  ")  # 先访问根节点
            yield from self.pre_oder(node.left)  # 遍历左子树
            yield from self.pre_oder(node.right)  # 遍历右子树
    # 中序遍历

    def in_oder(self, node: TreeNode[T]):
        if node:
            yield from self.in_oder(node.left)  # 先遍历左子树
            yield from print("data"+node+"  ")  # 访问根节点
            yield from self.in_oder(node.right)  # 遍历右子树

    # 后序遍历
    def post_oder(self, node: TreeNode[T]):
        yield from self.pre_oder(node.left)  # 遍历左子树
        yield from self.pre_oder(node.right)  # 遍历右子树
        yield from print("data"+node+"  ")  # 最后访问根节点

    def insert_root(self, x: T):
        self.root = TreeNode(value=x, left=self.root, right=None)

    def isEmpty(self):
        return self.root == None

    # 清除二叉树操作(递归)
    def clear(self, node: TreeNode):
        if node:
            self.clear(node.left)
            self.clear(node.right)
            node = None


if __name__ == "__main__":

    singer = TreeNode()

    genre_country = TreeNode("Country")
    genre_pop = TreeNode("Pop")

    album_fearless = TreeNode("Fearless")
    album_red = TreeNode("Red")
    album_1989 = TreeNode("1989")
    album_reputation = TreeNode("Reputation")
