import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.iface.ITree;
import dsa.impl.SLinkedList;
import dsa.impl.Tree;

public class Q3 {
	private static void preorder(ITree<String> tree, INode<String> n) {
		System.out.println(n.element());
		IIterator<INode<String>> i = tree.children(n);
		while(i.hasNext()) {
			preorder(tree,i.next());
		}
 		
	}
	
   private static INode<String> find(String e, INode<String> n,ITree<String> tree){
	  INode<String> temp = n;
	  INode<String> result = null;
	   if(temp.element().equals(e)){
		   result = temp;
		   return result;
	   }
	   else {
		   IIterator<INode<String>> i = tree.children(temp);
		   while(i.hasNext()&&result==null) {
			   result=find(e,i.next(),tree);
		   }
	   }
	   return result;
   }
   
   private static void printChildrenOf(INode<String> n,ITree<String> tree) {
	   IIterator<INode<String>> i = tree.children(n);
	   while(i.hasNext()) {
		   System.out.println(i.next().element());
	   }
   }
   private static int depthOf(String e, ITree<String> tree) {
	   int depth;
	   INode<String> n = find(e,tree.root(),tree);
	   if(n.equals(tree.root())) {
		   return depth=0;
	   }else {
		   depth = 1;
		   while(tree.parent(n)!=tree.root()) {
			   n = tree.parent(n);
			   depth++;
		   }
	   }	   
	   return depth;
   }
   private static void getExternals(INode<String> n,ITree<String> tree,SLinkedList<INode<String>> externals){
	   INode<String> temp = n;
	   if(tree.isExternal(temp)){
		   externals.insertLast(temp);
	   }
	   IIterator<INode<String>> i = tree.children(temp);
	   while(i.hasNext()) {
		   getExternals(i.next(),tree,externals);
	   }
	   
   }
   private static void getInternals(INode<String> n,ITree<String> tree,SLinkedList<INode<String>> internals){
	   INode<String> temp = n;
	   if(tree.isInternal(temp)){
		   internals.insertLast(temp);
	   }
	   IIterator<INode<String>> i = tree.children(temp);
	   while(i.hasNext()) {
		   getInternals(i.next(),tree,internals);
	   }
	   
   }
   private static int getHeight(ITree<String> tree) {
	   int temp=0;
	   int maxDepth=0;
	   SLinkedList<INode<String>> externals = new SLinkedList<INode<String>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<String>> n = externals.first();
	   maxDepth = depthOf(n.element().element(),tree);
	   while(externals.next(n)!=null) {
		   n = externals.next(n);
		   temp = depthOf(n.element().element(),tree);
		   if(temp>maxDepth) {
			   maxDepth = temp;
		   }
	   }
	   return maxDepth;
   }
   private static int countAncestors(String e, ITree<String> tree) {
	   INode<String> n = find(e,tree.root(),tree);
	   int count = 0;
	   while(n!=null) {
		   n = tree.parent(n);
		   count++;
	   }
	   return count;
   }
   
   private static int preorder_count(ITree<String> tree, INode<String> n,int count) {
		count++;
		IIterator<INode<String>> i = tree.children(n);
		while(i.hasNext()) {
			count=preorder_count(tree,i.next(),count);
		}
		return count;
	}
   
   private static int countDescendants(String e, ITree<String> tree) {
	   INode<String> n = find(e,tree.root(),tree);
	   int count = 0;
	   int result=preorder_count(tree,n,count);
	   return result;
   }
   
   private static void listExternals(ITree<String> tree) {
	   SLinkedList<INode<String>> externals = new SLinkedList<INode<String>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<String>> n = externals.first();
	   while(n!=null) {
		   System.out.println(n.element().element());
		   n = externals.next(n);
	   }
   }
   
   private static void listInternals(ITree<String> tree) {
	   SLinkedList<INode<String>> internals = new SLinkedList<INode<String>>();
	   getInternals(tree.root(),tree,internals);
	   INode<INode<String>> n = internals.first();
	   while(n!=null) {
		   System.out.println(n.element().element());
		   n = internals.next(n);
	   }
   }
   
   private static boolean isEdge(String u, String v, ITree<String> tree) {
	   INode<String> n1 = find(u,tree.root(),tree);
	   INode<String> n2 = find(v,tree.root(),tree);
	   INode<String> n3 = tree.parent(n2);
	   return n3.equals(n1);
   }
   
   private static void listPath(String start, String end, ITree<String> tree) {
	   SLinkedList<INode<String>> path = new SLinkedList<INode<String>>();
	   INode<String> n1 = find(start,tree.root(),tree);
	   INode<String> n2 = find(end,tree.root(),tree);
	   while(!tree.parent(n2).equals(n1)) {
		   path.insertFirst(n2);
		   n2 = tree.parent(n2);
	   }
	   path.insertFirst(n2);
	   path.insertFirst(n1);
	   INode<INode<String>> temp = path.first();
	   while(path.next(temp) != null) {
		   System.out.print(temp.element().element()+"-->");
		   temp = path.next(temp);
	   }
	   System.out.print(temp.element().element());
	   
   }
   
   public static void drawStructureOf(ITree<String> tree) {
	   SLinkedList<INode<String>> externals = new SLinkedList<INode<String>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<String>> temp = externals.first();
	   while(temp!=null) {
		   listPath(tree.root().element(), temp.element().element(), tree);
		   System.out.print("\n");
		   temp = externals.next(temp);
//		   i++;
	   }
   }
   private static void listChildrenOf(String e, ITree<String> tree) {
	   INode<String> n = find(e,tree.root(),tree);
	   IIterator<INode<String>> i = tree.children(n);
	   while(i.hasNext()) {
		   System.out.println(i.next().element());
	   }
   }
   
   private static void listSiblingsOf(String e, ITree<String> tree) {
	   INode<String> n = find(e,tree.root(),tree);
	   INode<String> p = tree.parent(n);
	   INode<String> temp;
	   IIterator<INode<String>> i = tree.children(p);
	   while(i.hasNext()) {
		   temp = i.next();
		   if(!temp.equals(n)) {
			   System.out.println(temp.element());
		   }
	   }
   }
   public static void main( String[] args ) {
      ITree<String> tree = Tree.createTreeC();
      
      System.out.println("Q3.a:");
      System.out.println(tree.root().element());
      
      System.out.println("Q3.b:");
      listInternals(tree);
      
      System.out.println("Q3.c:");
      System.out.println(countDescendants("cs016/",tree));
      
      System.out.println("Q3.d:");
      System.out.println(countAncestors("cs016/",tree));
      
      System.out.println("Q3.e:");
      listSiblingsOf("homeworks/",tree);
      
      System.out.println("Q3.f:");
      preorder(tree,find("projects/",tree.root(),tree));
      
      System.out.println("Q3.g:");
      System.out.println(depthOf("papers/",tree));
      
      System.out.println("Q3.h:");
      System.out.println(getHeight(tree));
      
      System.out.println("Q3.i:");
      drawStructureOf(tree);
      
      System.out.println(tree.size());
      System.out.println("Q3.c:");
      System.out.println(countDescendants("/user/rt/courses",tree));
      System.out.println(countDescendants("cs016/",tree));
      preorder(tree,tree.root());
      preorder(tree,find("cs016/",tree.root(),tree));
      // write your code to answer Question 3 here...
   }
}
