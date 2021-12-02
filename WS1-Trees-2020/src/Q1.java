import dsa.iface.IIterator;
import dsa.iface.INode;
import dsa.iface.ITree;
import dsa.impl.SLinkedList;
import dsa.impl.Tree;

public class Q1 {
	private static void preorder(ITree<Character> tree, INode<Character> n) {
		System.out.println(n.element());
		IIterator<INode<Character>> i = tree.children(n);
		while(i.hasNext()) {
			preorder(tree,i.next());
		}
 		
	}
   private static INode<Character> find(Character e, INode<Character> n,ITree<Character> tree){
	  INode<Character> temp = n;
	  INode<Character> result = null;
	   if(temp.element().equals(e)){
		   result = temp;
		   return result;
	   }
	   else {
		   IIterator<INode<Character>> i = tree.children(temp);
		   while(i.hasNext()&&result==null) {
			   result=find(e,i.next(),tree);
		   }
	   }
	   return result;
   }
   private static void printChildrenOf(INode<Character> n,ITree<Character> tree) {
	   IIterator<INode<Character>> i = tree.children(n);
	   while(i.hasNext()) {
		   System.out.println(i.next().element());
	   }
   }
   private static int depthOf(Character e, ITree<Character> tree) {
	   int depth;
	   INode<Character> n = find(e,tree.root(),tree);
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
   private static void getExternals(INode<Character> n,ITree<Character> tree,SLinkedList<INode<Character>> externals){
	   INode<Character> temp = n;
	   if(tree.isExternal(temp)){
		   externals.insertLast(temp);
	   }
	   IIterator<INode<Character>> i = tree.children(temp);
	   while(i.hasNext()) {
		   getExternals(i.next(),tree,externals);
	   }
	   
   }
   private static int getTreeHeight(ITree<Character> tree) {
	   int temp=0;
	   int maxDepth=0;
	   SLinkedList<INode<Character>> externals = new SLinkedList<INode<Character>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<Character>> n = externals.first();
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
   private static void listAncestors(Character e, ITree<Character> tree) {
	   INode<Character> n = find(e,tree.root(),tree);
	   while(tree.parent(n)!=null) {
		   System.out.println(n.element());
		   n = tree.parent(n);
	   }
	   System.out.println(n.element());
   }
   
   private static void listDescendants(Character e, ITree<Character> tree) {
	   INode<Character> n = find(e,tree.root(),tree);
	   preorder(tree,n);
   }
   private static void listExternals(ITree<Character> tree) {
	   SLinkedList<INode<Character>> externals = new SLinkedList<INode<Character>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<Character>> n = externals.first();
	   while(n!=null) {
		   System.out.println(n.element().element());
		   n = externals.next(n);
	   }
   }
   
   private static boolean isEdge(Character u, Character v, ITree<Character> tree) {
	   INode<Character> n1 = find(u,tree.root(),tree);
	   INode<Character> n2 = find(v,tree.root(),tree);
	   INode<Character> n3 = tree.parent(n2);
	   return n3.equals(n1);
   }
   
   private static void listPath(Character start, Character end, ITree<Character> tree) {
	   SLinkedList<INode<Character>> path = new SLinkedList<INode<Character>>();
	   INode<Character> n1 = find(start,tree.root(),tree);
	   INode<Character> n2 = find(end,tree.root(),tree);
	   while(!tree.parent(n2).equals(n1)) {
		   path.insertFirst(n2);
		   n2 = tree.parent(n2);
	   }
	   path.insertFirst(n2);
	   path.insertFirst(n1);
	   INode<INode<Character>> temp = path.first();
	   while(path.next(temp) != null) {
		   System.out.print(temp.element().element()+"-->");
		   temp = path.next(temp);
	   }
	   System.out.print(temp.element().element());
	   
   }
   
   public static void drawStructureOf(ITree<Character> tree) {
	   SLinkedList<INode<Character>> externals = new SLinkedList<INode<Character>>();
	   getExternals(tree.root(),tree,externals);
	   INode<INode<Character>> temp = externals.first();
	   while(temp!=null) {
		   listPath(tree.root().element(), temp.element().element(), tree);
		   System.out.print("\n");
		   temp = externals.next(temp);
	   }
   }
   
   public static void main( String[] args ) {
      ITree<Character> tree = Tree.createTreeA();
      
      System.out.println("Q1.a:");
      System.out.println(tree.root().element());
      
      System.out.println("Q1.b:");
      printChildrenOf(tree.root(),tree);
      
//      preorder(tree,tree.root());
//      Character e = 'G';
//      INode<Character> n = find(e,tree.root(),tree);
//      System.out.println(n.element());
      
      System.out.println("Q1.c:");
      System.out.println(depthOf('L',tree));
      
//      SLinkedList<INode<Character>> externals = new SLinkedList<INode<Character>>();
//      getExternals(tree.root(),tree,externals);
//	  INode<INode<Character>> n = externals.first();
//      for(int i=0; i<externals.size();i++) {
//    	  System.out.println(n.element().element());
//    	  n=externals.next(n);
//      }
      System.out.println("Q1.d:");
      System.out.println(getTreeHeight(tree));
      
      System.out.println("Q1.e:");
      listAncestors('G',tree);
      
      System.out.println("Q1.f:");
      listDescendants('B',tree);
      
      System.out.println("Q1.g:");
      listExternals(tree);
      
      System.out.println("Q1.h:");
      System.out.println(isEdge('N','L',tree));
      
      System.out.println("Q1.i:");
      listPath('D','N',tree);
      
      System.out.println("\nQ1.j:");
      drawStructureOf(tree);
      
      // write your code to answer Question 1 here...
   }
}
