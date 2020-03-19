import socket
import time

s = socket.socket()
PORT = 8000
maxConn = 999
IP = socket.gethostname()
print(IP)

s.bind(('',PORT))

s.listen(maxConn)
print("server started at "+IP+" on port "+str(PORT))


print("new connection added")


while True:
    clientsocket, address = s.accept()
    message = clientsocket.recv(1024).decode()
    print("server started at : " + str(address) + " on port : " + str(PORT))
    print(message)
