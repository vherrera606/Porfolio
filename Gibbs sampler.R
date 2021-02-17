
install.packages("MCMCpack")

library(MCMCpack)

curve(dinvgamma(x,0.05,0.05),0,10000)


#Prior: mu~N(820,sd=100)
#Prior2:sigma2~InvGamma(0.05,0.05)
#Simulate a data set

X<- c(850,740,900,1070,930,850,950,980,980,880,1000,980,930,650,760,
      810,1000,1000,960,960,960,940,960,940,880,800,850,880,900,840,830,790,810,
      880,880,830,800,790,760,800,880,880,880,860,720,720,620,860,970,950,880,
      910,850,870,840,840,850,840,840,840,890,810,810,820,800,770,760,740,750,
      760,910,920,890,860,880,720,840,850,850,780,890,840,780,810,760,810,790,
      810,820,850,870,870,810,740,810,940,950,800,810,870)

n<-length(X)
sig_0<- 100
a<-0.05; b<-0.05

#initial values

mu_sim<- mean(X)
sigma2_sim<- var(X)


#simulated length
n.samples<- 15000


#Initiate matrix to store the results

samples<- matrix(0,n.samples,2)
colnames<- c("mu","sigma2")

#MCMC:Gibbs sampler:

for(i in 1:n.samples){
  
  #update mu
  mu0<- (n*mean(X)*sigma2_sim^(-1)+0)/(n*sigma2_sim^(-1)+sig_0^(-20))
  var0<- 1/(n*sigma2_sim^(-1)+sig_0^(-20))
  
  mu_sim<-rnorm(1,mean=mu0,sd=sqrt(var0))
  
  #update sigma2_sim
  sigma2_sim<-rinvgamma(1,n/2+a,sum((X-mu_sim)^2)/2+b)
  
  #store results:
  samples[i,]<-c(mu_sim, sigma2_sim)
}

plot(samples[-(1:500),])


## 95% Equal tail credible interval and the posterior mean from marginal dist
## Extract mu's
sp<- (samples[501:n.samples,])[,1]
mean(sp)
quantile(sp,prob=c(0.025,0.977))

#Compare with 95% CI by inverting a LRT, e.g.,t-test
#t.test(X)$conf.int

## Diagnostic plot
## Trace plot: a time series plot
plot(sp,type="l")


