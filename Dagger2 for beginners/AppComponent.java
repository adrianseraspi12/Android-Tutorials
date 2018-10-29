import dagger.Component;

@Component(modules = RefrigeratorModule.class)
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
