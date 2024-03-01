import pandas as pd
import numpy  as  np
import matplotlib.pyplot as plt
import seaborn as sns
iris=sns.load_dataset( "iris")
iris.sepal_length
#取前十个观察 speal length柱状图
plt.title('speal length')
data_array=np.array(iris.sepal_length)
plt.bar(range(0,10),data_array[o:10])
plt.show()
#取一百个看散点图
plt.scatter(range(0,100),data_array[0:100])
plt.show()
sns.pairplot(iris) #绘制双变量分布
