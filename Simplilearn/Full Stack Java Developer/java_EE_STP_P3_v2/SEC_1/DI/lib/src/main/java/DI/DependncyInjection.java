package DI;
// Phase_3, Lesson 1:
// Dependency Injection manually

public class DependncyInjection {
		static class Dependency{
			String doWork() {
				return "Work is done!";
			}
		}
		
		static class Injected{
			private Dependency dependency;
			
			public Injected(Dependency dependency) {
				this.dependency=dependency;
			}
			
			void delegate() {
				System.out.println(dependency.doWork());
			}
			
		}
		
		public static void main(String[] args) {
			Injected injected = new Injected(new Dependency());
			injected.delegate();
		}
}
