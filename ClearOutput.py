import os, zipfile, time


def zipFiles(path):

	zipFile = zipfile.ZipFile("output/"+ str(int(time.time())) +".zip", 'w')

	csvs = [zipFile.write(path+f) for f in os.listdir(path) if f.endswith(".csv")]

	zipFile.close()
	
def removeCSV(path):
	csvs = [path+f for f in os.listdir(path) if f.endswith(".csv")]

	for csv in csvs:
		try:
			os.remove(csv)
		except OSError, e:
			print ("Error: %s - %s." % (e.filename, e.strerror))




if __name__ == "__main__":

	zipFiles("output/")
	removeCSV("output/")

