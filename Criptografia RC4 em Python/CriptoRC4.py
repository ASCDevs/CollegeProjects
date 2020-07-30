#Atividade Prática Supervisionada UNIP 2º SEMESTRE - CRIPTOGRAFIA
'''
> Programa de Criptografia baseado em RC4
> Objetivo de compreender o algoritmo de uma criptografia em RC4
> Praticas comandos básicos na linguagem Python
'''
import os
os.system("cls")


s=[]

#Irá criar uma lista personalizada para a saida dos caracteres
cod1='AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'
cod2='!@#$%&+=-*'
cod3='0123456789'
caracteres=[]

#Função que processa os caracteres à serem exibidos
def gera_caracteres():
    for i in range(256):
        caracteres.append(cod1[(i*3)%len(cod1)]+cod2[(i*4)%len(cod2)]+cod3[(i*i)%len(cod3)])

#Função KSA  - key-scheduling 
#Usado para iniciar a permutação na lista 's'
def ksa(chave):
    tamanho_chave = len(chave)
    
    #'s' é preenchido de 0 à 255
    s = list(range(256))
    #'j' é somado ao valor de 's' de acordo com 'i' e somado
    # ao valor da "chave" tmb de acord com 'i', tudo armazenado em 'j'
    j=0
    for i in range(256):
        j = (j+s[i]+chave[i%tamanho_chave])%256
        s[i], s[j] = s[j], s[i]
    
    return s

#PRGA - Pseudo-random generation algorithm - Algoritmo de geração pseudo-aleatória
def prga(s):
    tamanho_entrada = len(entrada)
    i=0
    j=0
    k=0
    result=list(range(tamanho_entrada))
    
    while k<tamanho_entrada:
        i = (i+1)%256
        j = (j+s[i])%256
        s[i], s[j] = s[j], s[i]
        result[k] = bin((s[(s[i] + s[j]) % 256])^entrada[k])[2:]
        k+=1
    
    return result

#Função que incia o KSA de acordo com os valores da chave inserida e aplica na função PRGA
def RC4(chave):
    s = ksa(chave)
    return prga(s)

#Função que retorna o número equivalente na tabela ASCII e retorna uma lista
def converte_unicode(n):
    lista = []
    for c in n:
        lista.append(ord(c))
    return lista

#Função que retorna os valores binário em valores decimais
def decimal_bin(n):
    for i in range(len(n)):
        x = (len(n[i])-1)
        decimal = 0
        for b in n[i]:
            if b == '1':
                decimal+=(2**x)
            x-=1
        n[i] = decimal
    return n

#Função que irá ler os caracteres criptografados e separar de 3 em 3
#Apartir da lista gerada, irá retornar os valores equivalentes dos caracteres gerados
def converte_chars(n):
    convertido = []
    texto = n
    tamanho = int((len(n))/3)
    for i in range(tamanho):
        silaba = texto[:3]
        texto = texto[3:]
        convertido.append(silaba)

    unicodes = []
    for x in convertido:
        indice = caracteres.index(x)
        unicodes.append(indice)

    return unicodes

#Exibe menu e armazena resposta
resp = input("- CRIPTOGRAFIA RC4 -\n1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n> ")
#Laço de repetição que aceita somente valores válidos
while (resp.isdigit()!=True) or (int(resp)!=1 and int(resp)!=2 and int(resp)!=3):
    os.system("cls")
    resp = input('- CRIPTOGRAFIA RC4 -\n1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n**Digite valor válido entre 1 e 3\n> ')

#Inicia um laço enquanto verdade que apenas é interrompido quando se tornar falso
#ou seja quando usuário optar por sair.
while True:

    #Enquanto a opção for de Criptografar
    while int(resp) == 1:
        os.system("cls")
        print('CRIPTOGRAFAR')
        #valor armazenado para chave
        chave = input("Entre com um texto para gerar chave: ")

        #Mensagem que será criptografada
        entrada = input("Digite uma mensagem e até 128 caracteres: ")

        #Valida se a mensagem possui 128 caracteres no máximo
        while len(entrada)>128:
            os.system("cls")
            entrada = input(f"Mensagem grande!({len(entrada)}) tamanho permitido é 128.\nNova mensagem: ")

        #Converte a chave para valores decimais
        chave = converte_unicode(chave)

        #inicia caracteres de exibição
        gera_caracteres()

        #Converte a entrada para valores decimais
        entrada = converte_unicode(entrada)
        
        #Inicia as permutações dos valores entre chave e texto
        fluxochave = RC4(chave)

        #Valores passam de binários para decimais
        fluxochave = decimal_bin(fluxochave)

        #Variável para armanezar resultado final
        final=''

        #Para cada número retornado em 'fluxochave' o laço irá buscar o equivalente nos caracteres
        for n in fluxochave:
            final+=caracteres[n]
        
        #Exibição da saída e opções de nova criptografia, descriptografar ou sair
        print('====================')
        print('Mensagem criptografada: (',final,')')
        print('====================')
        resp = input("1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n> ")
        while (resp.isdigit()!=True) or (int(resp)!=1 and int(resp)!=2 and int(resp)!=3):
            os.system("cls")
            resp = input('- CRIPTOGRAFIA RC4 -\n1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n**Digite valor válido entre 1 e 3\n> ')

    #Laço iniciado quando a opção é Descriptografar
    while int(resp) == 2:

        #Tratamento de erro Try/Except para não dar erro na execução do código
        try:
            os.system("cls")
            print('DESENCRIPTAR')
            #Valor da chave utilizada
            chave = input("Entre com a chave usada: ")

            #Mensagem que será criptografada
            entrada = input("Digite a mensagem criptografada: ")


            chave = converte_unicode(chave)
            gera_caracteres()
            entrada = converte_chars(entrada)
        
            fluxochave = RC4(chave)
            fluxochave = decimal_bin(fluxochave)

            print('=========================')
            final=''

            #Após o algoritmo RC4 ter recuperado o texto,
            #o método chr() retornará os caracteres originais
            #de acordo com os decimais gerados
            for n in fluxochave:
                final+=chr(n)

            print('Mensagem descriptografada:\n (',final,')')
        
        #Tratamento de erro caso os caractes não são condizentes
        except ValueError:
            print("======")
            print("Está mensagem não pertence à esta criptografia!")
            print("======")
        
        resp = input("1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n> ")
        while (resp.isdigit()!=True) or (int(resp)!=1 and int(resp)!=2 and int(resp)!=3) :
            os.system("cls")
            resp = input('- CRIPTOGRAFIA RC4 -\n1 - CRIPTOGRAFAR\n2 - DESENCRIPTOGRAFAR\n3 - SAIR\n**Digite valor válido entre 1 e 3\n> ')


    if int(resp)==3:

        #O laço apenas irá parar quando a variavel resp for igual a 3
        os.system("cls")
        print("====================")
        print("OBRIGADO - ATÉ MAIS!")
        print("========FIM=========")
        #break irá retornar False para o laço while True
        break