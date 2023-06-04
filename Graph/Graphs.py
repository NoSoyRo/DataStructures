class Node():
    def __init__(self, data):
        self.data = data
        self.next = None

class List():
    def __init__(self, head):
        self.head = head
        self.tail = self.head
    def append(self, node):
        self.tail.next = node
        self.tail = node
        self.tail.next = None
    
class Graph():
    def __init__(self, vertices):
        self.nVertices = vertices
        self.vertices = [None] * self.nVertices
    def addEdge(self, src, dest):
        if (self.vertices[src] == None and self.vertices[dest] == None):
            nodeSrc = Node(src)
            nodeDest = Node(dest)
            listNodeSrc = List(nodeSrc)
            listNodeDest = List(nodeDest)
            self.vertices[src] = listNodeSrc
            self.vertices[dest] = listNodeDest
            self.vertices[src].append(Node(dest))
            self.vertices[dest].append(Node(src))
        elif (self.vertices[src] == None and self.vertices[dest] != None):
            nodeSrc = Node(src)
            nodeDest = Node(dest)
            listNodeSrc = List(nodeSrc)
            self.vertices[src] = listNodeSrc
            self.vertices[dest].append(Node(src))
            self.vertices[src].append(Node(dest))
        elif (self.vertices[dest] == None and self.vertices[src] != None):
            nodeSrc = Node(src)
            nodeDest = Node(dest)
            listNodeDest = List(nodeDest)
            self.vertices[dest] = listNodeDest
            self.vertices[dest].append(Node(src))
            self.vertices[src].append(Node(dest))
        else:
            nodeSrc = Node(src)
            nodeDest = Node(dest)
            self.vertices[dest].append(Node(src))
            self.vertices[src].append(Node(dest))
    def printGraph(self):
        for i in self.vertices:
            print("vertice:   ", i.head.data)
            first = i.head
            aux = True
            while aux:
                nextVertex = first.next
                if nextVertex == None:
                    aux = False
                    print("         node ",first.data)
                    break
                print("         node ",first.data)
                first = first.next

if __name__ == "__main__":
    grafica = Graph(5)
    grafica.addEdge(0,1)
    grafica.addEdge(0,4)
    grafica.addEdge(1,4)
    grafica.addEdge(1,3)
    grafica.addEdge(1,2)
    grafica.addEdge(2,3)
    grafica.addEdge(4,3)    
    grafica.printGraph()

        
