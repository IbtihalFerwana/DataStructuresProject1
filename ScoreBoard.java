/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcs2101;

public class ScoreBoard<E>  {
    
    private static class DNode<E>{
        private GameEntry element;
        private DNode<E> prev;
        private DNode<E> next;
        
        public DNode(GameEntry e,DNode<E> p,DNode<E> n){
            
         element=e;
         prev=p;
         next=n;
            
        }
    
        public DNode(){
            
        }
        
         
        
        public GameEntry getElement(){
            return element;
        }
        
        public DNode<E> getPrev(){
            return prev;
        }
        
        public DNode<E> getNext(){
            return next;
        }
        
        public void setPrev(DNode<E> p){
            
            prev=p;
            
        }
        public void setNext(DNode<E> n){
            next=n;
            
        }
    }
        
        private DNode<E> header;
        private DNode<E> trailer;
        private int size=0;
        
        public ScoreBoard(){
            
            header=new DNode<>(null,null,null);
            trailer=new DNode<>(null,header,null);
            header.setNext(trailer);
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return (size==0)||(header.getNext()==trailer);
                    //
        }
        
     
        
        public void addBetween(GameEntry e,DNode<E> predecossor,DNode<E> successor){
        DNode<E> newnode=new DNode<>(e,predecossor,successor);
        predecossor.setNext(newnode);
        successor.setPrev(newnode);
        size++;
        }
        public void add(GameEntry e){
              DNode<E> nextotH=header.getNext();
              addBetween(e,header,nextotH);
        }
            
          
           
public DNode<E> getMin( ){
              DNode<E> minNode=header.getNext();  
              if(isEmpty())
                  System.out.println("list is empty");
              else{
                DNode<E> node= header.getNext(); 
                DNode<E> nextToNode=node.getNext();
                DNode<E> lessNode=null;
                DNode<E> leastScoreNode=null;
               
                minNode=header.getNext();
                GameEntry min=header.getNext().getElement();
                GameEntry newMin=min;
                while(nextToNode!= trailer){
                  
                    if(minNode.getElement().getScore()<nextToNode.getElement().getScore())
                    {
                        minNode=nextToNode;
                        newMin= minNode.getElement();
                    }
                
               
                nextToNode=nextToNode.getNext();
                        
                } }
           
              
                return minNode;
                }
                
                
          
         public void SortByMin( ){
              DNode<E> min=null;
             if(size==1)
                 min=header.getNext();
                 
                        
            else
             {
               min=remove(getMin());  
               SortByMin( );
               add(min.getElement());
             }
             }
        
        public GameEntry remove(int i){
             DNode<E> tmp=header;
           if(isEmpty())
                System.out.println("List is Empty");
            
          /**  if(i>size()||i<=0)
                System.out.println("please enter a proper value");
          */  
           else{
           int count=0;
           while(count<i){
               tmp=tmp.getNext();
             count++; 
           } 
        }
        remove(tmp);
          return tmp.getElement();
            
        }
        
        public  DNode<E>  remove(DNode<E> node){
            if(isEmpty())
                System.out.println("list is now Empty1");
            else
            {
            DNode<E> pred=node.getPrev();
            DNode<E> succ=node.getNext();
            
            pred.setNext(succ);
            succ.setPrev(pred);
            size--;
            }
       return node;}
        
        public void removeAll(){
            if(isEmpty())
                System.out.println("List is Already empty");
            else{
            while(header.getNext()!=trailer){
            
            remove(header.getNext());
                
            size--;    
            }
            System.out.println("list is now Empty2");
            }
        }
    

            public String listScores(){ // I changed this for GUI purposes
                String list="";
                if(isEmpty())
                    list= "The List is Empty";
               else
                {
                DNode<E> tmp=header;
                while(tmp.getNext().getElement()!=null){
                    list+=tmp.getNext().getElement().toString()+"  \n";
                    tmp=tmp.getNext();
                }
                
            }
                return list;
             
        } 
    }
    


