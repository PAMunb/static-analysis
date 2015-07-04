import os, re, commands, sys


def openFile():
	f = open('input.csv', 'w+')
	return f

def closeFile(file):
	file.close()

def listProjects(directory):
	return [d for d in os.listdir(directory) if os.path.isdir(os.path.join(directory, d))]


def listVersionProjects(directory):
	dirs = [directory+d+"/" for d in os.listdir(directory) if os.path.isdir(os.path.join(directory, d))]
	return dirs
	

def execCloc(project, dirs, file):
	
	#f.write("ProjectName, Version, Path, Files,Language,Blank,Comment,Code,\n")

	for dir in dirs:
		
		projectName = project
		#print "Project name",projectName

		comando = "cloc --match-f='^*.java' "+ dir + " --csv"
		conteudo = commands.getoutput(comando)
		
		#explodir a saida do cloc na quebra de linha
		csv = conteudo.split('\n')

		#capturar o total da linhas de codigo da saida csv 
		loc = (csv[-1]).split(',')[-1]

		# explodir o nome do diretorio pelo '-' e capturar os numeros que sao os da versao
		version = dir.split('-')[2]
		#print "Version", version

		file.write(projectName+","+ version+","+os.path.abspath(dir)+","+loc+",\n")
		#print os.path.abspath(dir)+", "+csv[-1]


if __name__ == "__main__":

	defaultDir = '/home/thiago/git/Ant/'

	#diretorio que contem os projetos a serem computados pelo cloc.
	pathDir = ''
	
	if len(sys.argv) is 2:
		dir = str(sys.argv[1])
		if os.path.isdir(dir):
			pathDir = dir
		else:
			pathDir = defaultDir
	else:
		pathDir = defaultDir


	file = openFile()


	projects = listProjects(pathDir)
	print projects

	for project in projects:
		pathProject = pathDir+"/"+project+"/"
		versionProjects = listVersionProjects(pathProject)
		versionProjects.sort()
		execCloc(project, versionProjects, file)

	closeFile(file)