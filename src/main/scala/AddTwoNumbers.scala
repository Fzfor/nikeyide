/**
  *
  * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
  *
  * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  *
  * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  *
  * 示例：
  *
  * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
  * 输出：7 -> 0 -> 8
  * 原因：342 + 465 = 807
  *
  * 来源：力扣（LeetCode）
  * 链接：https://leetcode-cn.com/problems/add-two-numbers
  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  * Create by fz on 2020/3/30
  */
object AddTwoNumbers {
  def main(args: Array[String]): Unit = {
    val node = new ListNode(2)
    node.next=new ListNode(4)
    node.next.next = new ListNode(3)

    val node1 = new ListNode(5)
    node1.next=new ListNode(6)
    node1.next.next = new ListNode(4)
//    println(node.x)

    val node2: ListNode = addTwoNumbers(node,node1)

    println(node2.x+"->"+node2.next.x+"->"+node2.next.next.x)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var carry = 0;
    var dummyNode: ListNode = new ListNode
    var head = dummyNode
    var a: Int = 0
    var b: Int = 0
    var sum: Int = 0

    var l11 = l1
    var l22 = l2

    while (l11 != null || l22 != null || carry != 0) {
      l11 match {
        case null => a = 0
        case _ => a = l11.x
      }

      if (l22 != null) {
        b = l22.x
      } else {
        b = 0
      }

      sum = a + b + carry

      head.next = new ListNode(sum % 10)
      head = head.next

      carry = sum / 10

      if (l11 != null) {
        l11 = l11.next
      }

      if (l22 != null){
        l22 = l22.next
      }
    }
    dummyNode.next
  }
}

class ListNode(var _x: Int = 0) {
  var x: Int = _x
  var next: ListNode = null


}
